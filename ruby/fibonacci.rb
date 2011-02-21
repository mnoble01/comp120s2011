#!/usr/bin/ruby

def fibonacci (n)
	if n == 0 
		0
	elsif n == 1
		1
	else
		fibonacci(n-2) + fibonacci(n-1)
	end
end

max = 35
n = 1
while n <= max
	result = fibonacci(n)
	puts "The fibonacci number for " + n.to_s + " is " + result.to_s
	n+=1
end
