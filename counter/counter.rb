#!/usr/bin/env ruby

require 'tempfile'

def count(file, number)
  start = Time.now
  1.upto(number) { |x| file.write x }
  duration = (Time.now - start) * 1000
  yield duration
end

if __FILE__ == $0
  Tempfile.open('counter') do |file|
    puts '+------------------+---------------+'
    puts '| Numeros impresos | Duracion (ms) |'
    puts '+------------------+---------------+'
	(ARGV.length > 0 ? ARGV.collect { |i| i.to_i } : 10.step(100, 10)).each do |number|         
      count(file, number) { |duration| puts '| %16d | %13.2f |' % [number, duration] }            
    end
    puts '+------------------+---------------+'
  end
end