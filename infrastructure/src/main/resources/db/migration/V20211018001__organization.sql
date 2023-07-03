CREATE TABLE `organization`
(
    `id`       INT         NOT NULL AUTO_INCREMENT,
    `name`  VARCHAR(45) NOT NULL,
    `description` VARCHAR(1000) NOT NULL,
    PRIMARY KEY (`id`)
);

ALTER TABLE `member` ADD COLUMN organization_id INT;