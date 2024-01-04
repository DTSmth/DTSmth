﻿
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

CREATE TABLE "client" (
    "client_id" serial   NOT NULL,
    "first_name" varchar(40)   NOT NULL,
    "last_name" varchar(40)   NOT NULL,
    "has_personal_care" boolean   NOT NULL,
    "has_lifting" boolean   NOT NULL,
    "address_1" varchar(40)   NOT NULL,
    "address_2" varchar(40)   NOT NULL,
    "zipcode" varchar(40)   NOT NULL,
    "phone_number" varchar(40)   NOT NULL,
    CONSTRAINT "pk_client" PRIMARY KEY (
        "client_id"
     )
);

CREATE TABLE "shift" (
    "shift_id" serial   NOT NULL,
    "client_id" int   NOT NULL,
    "service_id" int   NOT NULL,
    "total_hours" int   NOT NULL,
    "zipcode" varchar(40)   NOT NULL,
    "available" boolean   NOT NULL,
    CONSTRAINT "pk_shift" PRIMARY KEY (
        "shift_id"
     ),
    CONSTRAINT UQ_shift UNIQUE (client_id, service_id, total_hours, zipcode)
);

CREATE TABLE "service" (
    "service_id" int   NOT NULL,
    "service_name" varchar(40)   NOT NULL,
    CONSTRAINT "pk_service" PRIMARY KEY (
        "service_id"
     ),
    CONSTRAINT "uc_service_service_name" UNIQUE (
        "service_name"
    )
);

CREATE TABLE "client_service" (
    "client_id" int   NOT NULL,
    "service_id" int   NOT NULL,
    CONSTRAINT "pk_client_Service" PRIMARY KEY (
        "client_id","service_id"
     )
);

ALTER TABLE "shift" ADD CONSTRAINT "fk_shift_client_id" FOREIGN KEY("client_id")
REFERENCES "client" ("client_id");

ALTER TABLE "shift" ADD CONSTRAINT "fk_shift_service" FOREIGN KEY("service_id")
REFERENCES "service" ("service_id");

ALTER TABLE "client_service" ADD CONSTRAINT "fk_client_Service_client_id" FOREIGN KEY("client_id")
REFERENCES "client" ("client_id");

ALTER TABLE "client_service" ADD CONSTRAINT "fk_client_Service_service_id" FOREIGN KEY("service_id")
REFERENCES "service" ("service_id");

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

