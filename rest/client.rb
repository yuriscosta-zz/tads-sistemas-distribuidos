require 'httparty'
require 'json'

headers = {
    "Content-Type" => "application/json"
}

response = HTTParty.get("http://localhost:5000/api/v1/movies", :headers => headers)
json = JSON.parse(response.body)

puts response.body
puts response.message.to_json