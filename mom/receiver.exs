# Function to receive messages
defmodule Receive do
  def wait_for_messages do
    receive do
      {:basic_deliver, payload, _meta} ->
        IO.puts " [x] Received #{payload}"
        wait_for_messages
    end
  end
end

# Connecting to a broker on localhost
{:ok, connection} = AMQP.Connection.open
{:ok, channel} = AMQP.Channel.open(connection)

# Creating the queue
AMQP.Queue.declare(channel, "hello")

# Permission to receive messages
AMQP.Basic.consume(channel, "hello", nil, no_ack: true)

# Receiving messages
IO.puts " [*] Waiting for messages. To exit press CTRL+C, CTRL+C"
Receive.wait_for_messages