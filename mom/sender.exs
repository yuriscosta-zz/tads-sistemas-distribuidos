# Connecting to a broker on localhost
{:ok, connection} = AMQP.Connection.open
{:ok, channel} = AMQP.Channel.open(connection)

# Creating the queue
AMQP.Queue.declare(channel, "hello")

# Sending message
message = "Heathcliff, it's me, Cathy!"
AMQP.Basic.publish(channel, "", "hello", message)
IO.puts " [x] Sent #{message}"

# Closing connection
AMQP.Connection.close(connection)