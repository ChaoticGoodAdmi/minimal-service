CREATE SCHEMA IF NOT EXISTS public;

CREATE TABLE IF NOT EXISTS users (
                                     id SERIAL PRIMARY KEY,
                                     username VARCHAR(256) NOT NULL,
                                     first_name VARCHAR(256) NOT NULL,
                                     last_name VARCHAR(256) NOT NULL,
                                     email VARCHAR(256) NOT NULL,
                                     phone VARCHAR(20) NOT NULL,
                                     CONSTRAINT unique_username UNIQUE (username),
                                     CONSTRAINT unique_email UNIQUE (email)
);

CREATE INDEX IF NOT EXISTS idx_users_username ON users (username);
CREATE INDEX IF NOT EXISTS idx_users_email ON users (email);
