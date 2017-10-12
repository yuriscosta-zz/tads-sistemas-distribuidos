defmodule MomTest do
  use ExUnit.Case
  doctest Mom

  test "greets the world" do
    assert Mom.hello() == :world
  end
end
