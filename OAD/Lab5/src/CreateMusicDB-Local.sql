--	This is a MySQL script to
--		Create a database
--		Create a table
--		Add some data to the table

-- in latcs7 a database is already created using your username
-- the next 3 lines only applies if you are install MySQL on your own machine; uncomment both

drop database if exists musicDB; 
create database musicDB; 
use musicDB;

-- on latcs7 you will have to do
-- use your-username;

drop table if exists music_album;

create table music_album(
  id varchar(5),
  name varchar(100) not null,
  genre varchar(30) not null,
  compilation boolean,
  track_count int,
  primary key (id)
);

insert into music_album
values('a10', 'Van Halen II', 'Rock', false, 10);

insert into music_album
values('a20', 'Phoenix - United', 'Alernative/Indie', false, 10);

insert into music_album
values('a30', 'Creedence Clearwater Revival - The Ultimate Collection', 'Classic Rock', true, 40);

insert into music_album
values('a40', 'Boston', 'Rock', false, 8);

insert into music_album
values('a50', 'Jamaica - No Problem', 'Rock', true, 20);

insert into music_album
values('a55', 'Fantasia', 'Classic', false, 10);

-- listing all records in table
select *
from music_album;

