insert into users (name, username, password)
values ('John Doe', 'johndoe@gmail.com', '$2a$12$6W42D0rya/gcVt9bgFcWoOTxXzVanuVRyl0AB/nXkS.XegVtdGNdm'),
       ('Mike Smith', 'mikesmith@gmail.com', '$2a$12$6W42D0rya/gcVt9bgFcWoOTxXzVanuVRyl0AB/nXkS.XegVtdGNdm');

insert into tasks (title, description, status, expiration_date)
values ('buy cheese', null, 'TODO', '2023-01-29 12:00:00'),
       ('Do homework', 'Math, Physics, Literature', 'IN_PROGRESS', '2023-01-31 00:00:00'),
       ('Clean rooms', null, 'TODO', null),
       ('Call Mike', 'Ask about meeting', 'TODO', '2023-01-29 12:00:00');

insert into users_tasks (task_id, user_id)
values (1, 2),
       (2, 2),
       (3, 2),
       (4, 1);

insert into users_roles (user_id, role)
values (1, 'ROLE_ADMIN'),
       (1, 'ROLE_USER'),
       (2, 'ROLE_USER');