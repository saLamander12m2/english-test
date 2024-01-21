CREATE TABLE if not exists roles(
    id SERIAL PRIMARY KEY,
    name varchar UNIQUE
);

CREATE TABLE if not exists users_roles(
    id SERIAL PRIMARY KEY,
    user_id int NOT NULL,
    role_id int NOT NULL
);

CREATE INDEX user_id_idx ON users_roles(user_id);
CREATE INDEX roles_id_idx ON users_roles(role_id);

ALTER TABLE users_roles ADD CONSTRAINT fk_users_roles_user_id FOREIGN KEY (user_id) REFERENCES users(id);
ALTER TABLE users_roles ADD CONSTRAINT fk_users_roles_roles_id FOREIGN KEY (role_id) REFERENCES roles(id);