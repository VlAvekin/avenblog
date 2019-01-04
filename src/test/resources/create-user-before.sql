delete from user_role;
delete from usr;

insert into usr(id, active, password, username) value
(1, true, '$2a$08$lgaenYvJVfwAF/k91xbfSuFSIGKvc.PFyUqJ/PPLqWvhFgjQZ7cQe', '3'),
(1, true, '$2a$08$VWwUzmiacsesWX8XdblgNuOGFCC9xcyDK.0Ik2FBzQMMdUq6RxC7.', '4');

insert into user_role(user_id, roles) value
(1, 'USER');
(2, 'USER'), (2, 'ADMIN');