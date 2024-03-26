create constraint for (genres:Genre) require genres.id is unique;
create constraint for (artists:Artist) require artists.id is unique;
create constraint for (albums:Album) require albums.id is unique;
create constraint for (songs:Song) require songs.id is unique;

LOAD CSV WITH HEADERS FROM "file:///genres.csv" AS row
MERGE (genres:Genre { id: row.id })
SET genres += row;

LOAD CSV WITH HEADERS FROM "file:///artists.csv" AS row
MERGE (artists:Artist { id: row.id })
SET artists += row, artists.birthDate = date(split(row.birthDate, '/')[2] + '-' + split(row.birthDate, '/')[1] + '-' + split(row.birthDate, '/')[0]);

LOAD CSV WITH HEADERS FROM "file:///albums.csv" AS row
MERGE (albums:Album { id: row.id })
SET albums += row, albums.price = toFloat(row.price), albums.yearOfRelease = toInteger(row.yearOfRelease);

LOAD CSV WITH HEADERS FROM "file:///songs.csv" AS row
MERGE (songs:Song { id: row.id })
SET songs += row;

LOAD CSV WITH HEADERS FROM "file:///songs.csv" AS row
MATCH (albums:Album { id: row.albumId })
MATCH (songs:Song { id: row.id })
MERGE (albums)-[:HAVE]->(songs);


LOAD CSV WITH HEADERS FROM "file:///album_details.csv" AS row
MATCH (albums:Album { id: row.albumId })
MATCH (artists:Artist { id: row.artistId })
MERGE (albums)-[:BE_PERFORMED]->(artists);

LOAD CSV WITH HEADERS FROM "file:///albums.csv" AS row
MATCH (albums:Album { id: row.id })
MATCH (genres:Genre { id: row.genreId })
MERGE (albums)-[:BELONG_TO]->(genres);

