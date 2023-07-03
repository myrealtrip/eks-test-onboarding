CREATE TABLE `member`
(
    `id`       INT         NOT NULL AUTO_INCREMENT,
    `user_id`  VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC)
);