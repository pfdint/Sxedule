#!/usr/bin/perl
# specifics.sh
# by pfdint
# created: 2014-05-28
# modified: 2014-06-01
# purpose: Create a script which generates environment specific files from a general one.

# specifics will generate files which are specific to use defined implementations.
# You pass specifics a basename, such as "example", and keep the content and meta file
# in the directory specified by your basename. So, if you pass "/path/to/example", you
# had better have the files /path/to/example.content and path/to/example.meta . You can
# specify as many basenames as you like. The content file should have variables wherever
# you like denoted @{variablenamehere} . The meta file should have that variable name
# with however many instances you wish to generate. An example meta file:

#%
#particular.dev
#particular.stg
#particular.prd
#%variablenamehere
#bronze
#silver
#gold

# Note that there should be the same number of implementations under each variable. To
# specify a blank variable, leave a space on that line. Blank lines and comments (#) are
# ignored.
# You MUST have a heading of just % with the filenames you wish to generate. This heading
# is what determines the number of instances you have.
# The filenames are positionally matched to their variable value. Meaning, if dev is the
# first filename, all of the values for dev should be first under their variable name
# heading.

use strict;
use warnings;

if ( @ARGV < 0 ) {
    die "No arguments specified";
}

foreach (@ARGV) {

    my $basename = $_;
    my $content_file_name = $basename . ".content";
    my $meta_file_name = $basename . ".meta";

    open(my $content_file, "<", $content_file_name) or die "No content file \"$content_file_name\" present: $!";
    open(my $meta_file, "<", $meta_file_name) or die "No meta file \"$meta_file_name\" present: $!";

    my @content_array = <$content_file>;
    my @meta_array = <$meta_file>;

    close($content_file);
    close($meta_file);

    @meta_array = grep(!/^#/, @meta_array);
    @meta_array = grep(!/^$/, @meta_array);
    @meta_array = grep(s/\n$//, @meta_array);

    #Now search for %, set index, find next %.*, set lastindex, snip it out as filenames

    my $filenames_start_index;
    my $filenames_end_index;

    for (my $index = 0; $index < @meta_array; $index++) {
        $_ = $meta_array[$index];
        if (/^%$/) {
            $filenames_start_index = $index;
            last;
        }
    }
    
    for (my $index = $filenames_start_index + 1; $index < @meta_array; $index++) {
        $_ = $meta_array[$index];
        if (/^%/) {
            $filenames_end_index = $index;
            last;
        }
    }

    my @FILENAMES = splice(@meta_array, $filenames_start_index, $filenames_end_index - $filenames_start_index);

    my %meta_word_table;
    for (my $index = 0; $index < @meta_array; $index += @FILENAMES) {

        my @working_array;
        for (my $instance = 1; $instance < @FILENAMES; $instance++) {
            my $key_value = $meta_array[$index + $instance];
            push(@working_array, $key_value);
        }

        my $variable_name = substr($meta_array[$index], 1);
        $meta_word_table{$variable_name} = \@working_array;

    }

    shift(@FILENAMES);

    for (my $current_instance = 0; $current_instance < @FILENAMES; $current_instance++) {

        open(my $instance_file, ">", $FILENAMES[$current_instance]);

        my @content_array_instance_copy = @content_array;

        for (keys %meta_word_table) {

            my $current_key = $_;
            my $current_key_value = @{$meta_word_table{$current_key}}[$current_instance];

            foreach (@content_array_instance_copy) {
                $_ =~ s/\@{$current_key}/$current_key_value/g;
            }

        }

        print($instance_file @content_array_instance_copy);

        close($instance_file);

    }

}
