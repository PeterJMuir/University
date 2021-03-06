--	This is a MySQL script to
--		Create a database
--		Create a table
--		Add some data to the table

-- in latcs7 a database is already created using your username
-- the next 3 lines only applies if you are install MySQL on your own machine; uncomment both

-- drop database if exists mymusic; -- own machine MySQL instance
-- create database mymusic; -- own machine MySQL instance
-- use mymusic;

-- on latcs7 you will have to do
use your-username;

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
values('a10', 'Van Halen II', 'Rock', 0, 10);

insert into music_album
values('a20', 'PHOenix - United', 'Alernative/Indie', 0, 10);

insert into music_album
values('a30', 'Creedence Clearwater Revival - The Ultimate Collection', 'Classic Rock', 1, 40);

insert into music_album
values('a40', 'Boston', 'Rock', 0, 8);

insert into music_album
values('a50', 'Jamaica - No Problem', 'Rock', 0, 10);

insert into music_album
values('a55', 'Jamaica - No Problem', 'Rock', 0, 10);

-- listing all records in table
select *
from music_album;

-- listing all records in table, sorted by name in ascending order
select *
from music_album
order by name;

select *
from music_album
order by name asc;

-- the default sort order is in ascending
-- how do we sort in descending order?

-- update name of record with id 'a20'
update music_album
set name = 'Phoenix - United'
where id = 'a20';

-- delete record with id 'a55'
delete from music_album
where id = 'a55';