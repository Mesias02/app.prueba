CREATE TABLE IF NOT EXISTS users (
    id SERIAL,
    name VARCHAR (255) NOT NULL,
    age INT NOT NULL,
    emergency VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS reminders (
    id SERIAL,
    user_id INT NOT NULL,
    description VARCHAR (225) NOT NULL,
    date_time TIMESTAMP NOT NULL,
    status_reminder_status BOOLEAN ,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
 );

