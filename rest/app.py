import os
import html, json
from flask import Flask, jsonify, request
from bs4 import BeautifulSoup
from urllib.request import urlopen


app = Flask(__name__)

@app.route("/api/v1/movies", methods=["GET"])
def list_movies():
    """ Returns all the movies """
    html_doc = urlopen("http://www.adorocinema.com/filmes/numero-cinemas/").read()
    soup = BeautifulSoup(html_doc, "html.parser")

    data = []
    for dataBox in soup.find_all("div", class_="card card-entity card-entity-list cf"):
        name = dataBox.find("h2", class_="meta-title")
        img = dataBox.find(class_="thumbnail")
        synopsis = dataBox.find("div", class_="synopsis")
        days = dataBox.find(class_="meta-body").find(class_="meta-body-item meta-body-info")

        data.append({"name": name.text.strip(),
                     "poster": img.img['src'].strip(),
                     "synopsis": synopsis.text.strip(),
                     "Date": days.text[1:23].strip().replace('/', ' ')})

    return jsonify({"filmes":data})


if __name__ == '__main__':
    port = int(os.environ.get('PORT', 5000))
    app.run(host='127.0.0.1', port=port)
