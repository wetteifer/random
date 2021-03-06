class Rotate

  def initialize
    rotate 13
  end

  def rotate(rotation)
    keys   = ('a'..'z').to_a
    values = keys.rotate rotation

    @encrypt_hash = Hash[keys.zip values]
    @decrypt_hash = Hash[values.zip keys]

    keys   = nil
    values = nil
  end
  
  def cipher(hash, string)
    string.chars.collect do |c|
      unless c.downcase!
        hash.has_key?(c) ? hash[c] : c
      else
        hash.has_key?(c) ? hash[c].upcase : c
      end
    end
  end

  def encrypt(string)
    puts cipher(@encrypt_hash, string).join
  end

  def decrypt(string)
    puts cipher(@decrypt_hash, string).join
  end

end

# ???

def main
  r = Rotate.new
  
  if ARGV.empty?
    puts "Usage:\n\n(rotate)  -r [number]\n(encrypt) -e [string]\n(decrypt) -d [string]"
    return
  end
  
  ARGV.each_with_index do |arg, index|
    next unless arg.start_with? '-'
    if arg == '-r'
      r.rotate  ARGV[index + 1].to_i
    elsif arg == '-e'
      r.encrypt ARGV[index + 1]
    elsif arg == '-d'
      r.decrypt ARGV[index + 1]
    end
  end  
end

if __FILE__ == $0
  main
end