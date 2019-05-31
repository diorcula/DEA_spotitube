INSERT INTO tracks(title, performer, album, playcount, publication_date, description, offline_available, duration)
VALUES('The Bomb', 'Pigeon', 'Super Album', 25, '12/06/1997', 'I am the bomb and about to blow up', 0, 193);

INSERT INTO tracks(title, performer, album, playcount, publication_date, description, offline_available, duration)
VALUES('Gucci Gang', 'Lil Pump', 'Gucci Album', 2, '29/07/1994', 'Gaat over gucci kleding', 0, 180);

INSERT INTO Users(username, password, token) 
VALUES('Test', 'password', 'token');

INSERT INTO playlists(name, owner, owner_id) 
VALUES('Test', 0, 1);

INSERT INTO playliststracks 
VALUES(1,1);	