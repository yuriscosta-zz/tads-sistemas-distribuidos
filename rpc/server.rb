require "xmlrpc/server"

my_server = XMLRPC::Server.new(8000)

my_server.add_handler("add") do |a, b|
    a + b
end

my_server.add_handler("pow") do |a, b|
    if a == 0 && b == 0
        raise XMLRPC::FaultException.new(1, "Undefined")
    else
        a ** b
    end
end

my_server.add_handler("mul") do |a, b|
    a * b
end

my_server.set_default_handler do |name, *args|
    raise XMLRPC::FaultException.new(-99, "Method #{name} missing" +
                                     " or wrong numbers of parameters!")
end

my_server.serve
