require "xmlrpc/client"

server = XMLRPC::Client.new("localhost", "/RPC2", 8000)
begin
  param = server.call("pow", 10, 2)
  puts "Resposta: #{param}"
  param = server.call("add", 80, 40)
  puts "Resposta: #{param}"
  param = server.call("mul", 4, 3)
  puts "Resposta: #{param}"
  param = server.call("sub", 2, 10)
  puts "Resposta: #{param}"
rescue XMLRPC::FaultException => e
  puts "Error:"
  puts e.faultCode
  puts e.faultString
end
