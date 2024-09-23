CREATE SEQUENCE hibernate_auction_sequence;
CREATE TABLE app_user(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255)
);
CREATE TABLE contact_info(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    area_code VARCHAR(4) NOT NULL,
    mobile_phone VARCHAR(9) NOT NULL UNIQUE,
    landline_phone VARCHAR(9),
    email VARCHAR(255) NOT NULL UNIQUE,
    FOREIGN KEY (user_id) REFERENCES app_user(id)
);
CREATE TABLE address(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    street_name VARCHAR(255) NOT NULL,
    street_number VARCHAR(10) NOT NULL,
    flat_number VARCHAR(10) NOT NULL,
    post_code VARCHAR(6) NOT NULL,
    city VARCHAR(100) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES app_user(id)
);
CREATE TABLE personal_info(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES app_user(id)
);
CREATE TABLE authority(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);
CREATE TABLE user_authority(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    authority_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES app_user(id),
    FOREIGN KEY (authority_id) REFERENCES  authority
);