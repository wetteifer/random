require 'tempfile'

def count(f, n)
  start = Time.now
  1.upto(n) { |x| f.write x }
  (Time.now - start) * 1000
end

Tempfile.open('count') { |f| (ARGV.empty?? 10.step(100, 10) : ARGV.collect { |i| i.to_i }).each { |n| puts '%d: %.2f ms' % [n, count(f, n)] } }
