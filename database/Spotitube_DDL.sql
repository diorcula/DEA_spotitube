Drop database Spotitube;

CREATE DATABASE Spotitube;

use Spotitube;

CREATE TABLE tracks(
id int IDENTITY(1,1),
title varchar(255),
performer varchar(255),
album varchar(255),
playcount int,
publication_date varchar(255),
description varchar(255),
offline_available tinyint,
duration int,
PRIMARY KEY(id)
);

CREATE TABLE users(
id int IDENTITY(1,1),
username varchar(255),
password varchar(255),
token varchar(255),
PRIMARY KEY(id));

CREATE TABLE playlists(
id int IDENTITY(1,1),
name varchar(255),
owner tinyint,
owner_id int,
FOREIGN KEY(owner_id) REFERENCES users(id),
PRIMARY KEY(id));

CREATE TABLE playliststracks(
playlist_id int,
track_id int,
FOREIGN KEY(playlist_id) REFERENCES playlists(id)
ON DELETE CASCADE
ON UPDATE CASCADE,
FOREIGN KEY(track_id) REFERENCES tracks(id)
ON DELETE CASCADE
ON UPDATE CASCADE
);
