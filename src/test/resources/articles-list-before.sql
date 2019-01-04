delete from articles;

insert into articles(id, brief_descriptions, text, theme, user_id) values
(1, 'first', 'my-text first', 'my', 1),
(2, 'second', 'my-text second', 'my', 1),
(3, 'third', 'my-text third', 'my', 1),
(4, 'fourth', 'my-text fourth', 'my', 1);

alter sequence hibernate_sequence restаrt with 10;