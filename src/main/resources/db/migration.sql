CREATE SCHEMA IF NOT EXISTS public;

CREATE TABLE IF NOT EXISTS users (
                                     id BIGINT PRIMARY KEY,
                                     first_name VARCHAR(256) NOT NULL,
                                     last_name VARCHAR(256) NOT NULL,
                                     phone VARCHAR(20) NOT NULL
);
