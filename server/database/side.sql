-- Database: side

BEGIN TRANSACTION;

DROP TABLE IF EXISTS app_user;

CREATE TABLE app_user (
	user_id serial,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	display_name varchar(50),
	img_url varchar(500),
	short_bio varchar(500),
	CONSTRAINT PK_app_user PRIMARY KEY (user_id),
	CONSTRAINT UQ_username UNIQUE (username)
);

------------------------------ Data -------------------------------------------

-- Users - all have password: 'password'
INSERT INTO app_user (username, password_hash, role, display_name, img_url, short_bio)
	VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', null, null, null);
INSERT INTO app_user (username, password_hash, role, display_name, img_url, short_bio)
	VALUES ('job_coach','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Imani',
		'https://source.boringavatars.com/bauhaus/80/job_coach',
		'Career coach, specializing in working with students fresh out of college and career changers, with a special interest in technology roles.');
INSERT INTO app_user (username, password_hash, role, display_name, img_url, short_bio)
	VALUES ('newbie_coder','$2a$10$We8.y4IV/uQOPT1crppxR.aASgeKFr24ISrkHcqWWSYlxRu4oeqE6','ROLE_USER', null,
		'https://source.boringavatars.com/beam/80/newbie_coder',
		'New parent turned coder, with a passion for basketball, stats, and a good laugh.');
INSERT INTO app_user (username, password_hash, role, display_name, img_url, short_bio)
	VALUES ('troublemaker','$2a$10$K/XxMq03OaJM4AhLU7YE3eQh1KAd8/gzWIOWLgBqVrb5AoSy.pmSK','ROLE_USER', null, null, null);

COMMIT TRANSACTION;
