ALTER TABLE `member`
    CHANGE COLUMN `organization_id` `organization_id` INT NOT NULL ,
    ADD INDEX `organization_id_idx` (`organization_id` ASC);
;
ALTER TABLE `member`
    ADD CONSTRAINT `fk_organization`
        FOREIGN KEY (`organization_id`)
            REFERENCES `organization` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;
