#!/usr/bin/env ruby

require 'tempfile'

def count(f, n)
  start = Time.now
  1.upto(n) { |x| f.write x }
  (Time.now - start) * 1000
end

Tempfile.open('counter') do |f|
  puts '+------------------+---------------+'
  puts '| Numeros impresos | Duracion (ms) |'
  puts '+------------------+---------------+'
  (ARGV.empty?? 10.step(100, 10) : ARGV.collect { |i| i.to_i }).each { |n| puts '| %16d | %13.2f |' % [n, count(f, n)] }
  puts '+------------------+---------------+'
end
