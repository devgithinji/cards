
DROP TABLE IF EXISTS cards;

CREATE TABLE cards
(
    card_id          INT AUTO_INCREMENT NOT NULL,
    card_number      VARCHAR(100)       NOT NULL,
    customer_id      INT                NOT NULL,
    card_type        VARCHAR(100)       NOT NULL,
    total_limit      INT                NOT NULL,
    amount_used      INT                NOT NULL,
    available_amount INT                NOT NULL,
    create_dt        TIMESTAMP,
    CONSTRAINT pk_cards PRIMARY KEY (card_id)
);

INSERT INTO cards (card_number, customer_id, card_type, total_limit, amount_used, available_amount, create_dt)
VALUES ('4565XXXX4656', 1, 'Credit', 10000, 500, 9500, CURDATE());

INSERT INTO cards (card_number, customer_id, card_type, total_limit, amount_used, available_amount, create_dt)
VALUES ('3455XXXX8673', 1, 'Credit', 7500, 600, 6900, CURDATE());

INSERT INTO cards (card_number, customer_id, card_type, total_limit, amount_used, available_amount, create_dt)
VALUES ('2359XXXX9346', 1, 'Credit', 20000, 4000, 16000, CURDATE());
