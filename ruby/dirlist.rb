#!/usr/bin/ruby

Dir.open('/usr/bin') {
	|d| d.each {
		|x| puts x
	}
}
