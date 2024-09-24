DROP TABLE IF EXISTS user_authority;
ALTER TABLE app_user ADD COLUMN authority_id BIGSERIAL;
ALTER TABLE app_user ADD CONSTRAINT fk_authority FOREIGN KEY (authority_id) REFERENCES authority(id);
ALTER TABLE address
    RENAME COLUMN post_code TO postal_code;

