INSERT INTO users (username, password, enabled) VALUES ('user', 'pass', true);
INSERT INTO users (username, password, enabled) VALUES ('admin', 'pass', true);


INSERT INTO authorities(username, authority) values ('user','ROLE_USER');
INSERT INTO authorities(username, authority) values ('admin','ROLE_ADMIN');