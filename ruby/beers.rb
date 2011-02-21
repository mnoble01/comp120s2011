#!/usr/bin/ruby

beers = 99
original = beers
while beers > 0
	puts beers.to_s + " bottles of beer on the wall, " + beers.to_s + " bottles of beer."
	beers-=1
	if beers == 0
		puts "Take one down and pass it around, no more bottles of beer on the wall."
	else
		puts "Take one down and pass it around, " + beers.to_s + " bottles of beer on the wall."
	end
end
puts "No more bottles of beer on the wall, no more bottles of beer."
puts "Go to the store and buy some more, " + original.to_s + " bottles of beer on the wall."
