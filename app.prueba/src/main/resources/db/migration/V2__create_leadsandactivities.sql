CREATE TABLE IF NOT EXISTS leads (
    id SERIAL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    status VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS activities (
    id SERIAL,
    lead_id BIGINT NOT NULL,
    description TEXT NOT NULL,
    timestamp TIMESTAMP DEFAULT BOOLEAN,
    PRIMARY KEY (id),
    FOREIGN KEY (lead_id) REFERENCES leads(id) ON DELETE CASCADE
);

