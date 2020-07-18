-- auth0.users definition

-- Drop table

-- DROP TABLE auth0.users;

CREATE TABLE IF NOT EXISTS auth0.users (
	user_id varchar NOT NULL,
	email varchar NOT NULL,
	mobile_no varchar NOT NULL,
	password varchar NOT NULL,
	user_type bool NOT NULL,
	create_date timestamp NULL,
	update_date timestamp NULL,
	CONSTRAINT users_pk PRIMARY KEY (user_id),
	CONSTRAINT users_un UNIQUE (mobile_no)
);

-- auth0.address definition

-- Drop table

-- DROP TABLE auth0.address;

CREATE TABLE IF NOT EXISTS auth0.address (
	city varchar NULL,
	state varchar NULL,
	address_id varchar NOT NULL,
	country varchar NULL,
	pincode int4 NULL,
	landmark varchar NULL,
	address_line_1 varchar NULL,
	geo_location_id varchar NULL,
	CONSTRAINT address_pk PRIMARY KEY (address_id)
);

-- auth0.geo_location definition

-- Drop table

-- DROP TABLE auth0.geo_location;

CREATE TABLE IF NOT EXISTS auth0.geo_location (
	geo_location_id varchar NULL,
	geo_coordinates varchar NULL,
	user_id varchar NULL,
	user_type varchar NULL
);


-- auth0.users_details definition

-- Drop table

-- DROP TABLE auth0.users_details;

CREATE TABLE IF NOT EXISTS auth0.users_details (
	user_id varchar NOT NULL,
	email varchar NULL,
	first_name varchar NULL,
	last_name varchar NULL,
	address_id varchar NULL,
	CONSTRAINT users_details_pk PRIMARY KEY (user_id)
);


-- auth0.users_details foreign keys

ALTER TABLE auth0.users_details ADD CONSTRAINT users_details_fk FOREIGN KEY (user_id) REFERENCES users(user_id);
ALTER TABLE auth0.users_details ADD CONSTRAINT users_details_fk_1 FOREIGN KEY (address_id) REFERENCES address(address_id);

-- auth0.job_post definition

-- Drop table

-- DROP TABLE auth0.job_post;

CREATE TABLE IF NOT EXISTS auth0.job_post (
	job_id varchar NOT NULL,
	user_id varchar NOT NULL,
	job_description varchar NULL,
	updated_date varchar NULL,
	created_date varchar NULL,
	job_type varchar NULL,
	status varchar NULL,
	metadata json NULL,
	contact_details json NULL,
	compensation int8range NULL,
	is_deleted bool NULL,
	address_id varchar NULL,
	working_hours int4 NULL,
	gender varchar NULL,
	CONSTRAINT job_post_pk PRIMARY KEY (job_id),
	CONSTRAINT job_post_un UNIQUE (user_id, job_id)
);


-- auth0.job_post foreign keys

ALTER TABLE auth0.job_post ADD CONSTRAINT job_post_fk FOREIGN KEY (user_id) REFERENCES users(user_id);
ALTER TABLE auth0.job_post ADD CONSTRAINT job_post_fk_1 FOREIGN KEY (address_id) REFERENCES address(address_id);

-- auth0.job_post definition

-- Drop table

-- DROP TABLE auth0.job_post;

CREATE TABLE IF NOT EXISTS auth0.job_post (
	job_id varchar NOT NULL,
	user_id varchar NOT NULL,
	job_description varchar NULL,
	updated_date varchar NULL,
	created_date varchar NULL,
	job_type varchar NULL,
	status varchar NULL,
	metadata json NULL,
	contact_details json NULL,
	compensation int8range NULL,
	is_deleted bool NULL,
	address_id varchar NULL,
	working_hours int4 NULL,
	gender varchar NULL,
	CONSTRAINT job_post_pk PRIMARY KEY (job_id),
	CONSTRAINT job_post_un UNIQUE (user_id, job_id)
);


-- auth0.job_post foreign keys

ALTER TABLE auth0.job_post ADD CONSTRAINT job_post_fk FOREIGN KEY (user_id) REFERENCES users(user_id);
ALTER TABLE auth0.job_post ADD CONSTRAINT job_post_fk_1 FOREIGN KEY (address_id) REFERENCES address(address_id);

-- auth0.job_reviews definition

-- Drop table

-- DROP TABLE auth0.job_reviews;

CREATE TABLE IF NOT EXISTS auth0.job_reviews (
	job_id varchar NOT NULL,
	"comments" json NULL,
	CONSTRAINT job_reviews_pk PRIMARY KEY (job_id)
);


-- auth0.job_reviews foreign keys

ALTER TABLE auth0.job_reviews ADD CONSTRAINT job_reviews_fk FOREIGN KEY (job_id) REFERENCES job_post(job_id);



-- auth0.chat_history definition

-- Drop table

-- DROP TABLE auth0.chat_history;

CREATE TABLE IF NOT EXISTS auth0.chat_history (
	user_id_1 varchar NULL,
	user_id_2 varchar NULL,
	chat_backup_id varchar NOT NULL,
	messages json NULL,
	CONSTRAINT chat_history_pk PRIMARY KEY (chat_backup_id),
	CONSTRAINT chat_history_un UNIQUE (user_id_1, user_id_2)
);

-- auth0.job_seeker_profile definition

-- Drop table

-- DROP TABLE auth0.job_seeker_profile;

CREATE TABLE IF NOT EXISTS auth0.job_seeker_profile (
	job_id varchar NOT NULL,
	user_id varchar NULL,
	job_description varchar NULL,
	job_type varchar NULL,
	created_date varchar NULL,
	updated_date varchar NULL,
	address_id varchar NULL,
	compensation int8range NULL,
	working_hours int4 NULL,
	metadata json NULL,
	is_deleted bool NULL,
	CONSTRAINT job_seeker_profile_pk PRIMARY KEY (job_id)
);


-- auth0.job_seeker_profile foreign keys

ALTER TABLE auth0.job_seeker_profile ADD CONSTRAINT job_seeker_profile_fk FOREIGN KEY (user_id) REFERENCES users(user_id);
ALTER TABLE auth0.job_seeker_profile ADD CONSTRAINT job_seeker_profile_fk_1 FOREIGN KEY (address_id) REFERENCES address(address_id);



