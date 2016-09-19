CREATE DATABASE IF NOT EXISTS myDiary DEFAULT CHARACTER SET utf8 ;
USE myDiary ;

-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS usuario (
  idUsuario INT NOT NULL AUTO_INCREMENT,
  login VARCHAR(45) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  PRIMARY KEY (idUsuario),
/* Impede a criação de dois usuários com mesmo login*/
  UNIQUE INDEX idUsuario_UNIQUE (idusuario ASC), 
  UNIQUE INDEX login_UNIQUE (login ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`diario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS diario (
  idanotacao INT NOT NULL AUTO_INCREMENT,
  usuario_idusuario INT NOT NULL, /* Chave estrangeira para associar usuário às anotações*/
  anotacao VARCHAR(255) NULL,
  PRIMARY KEY (idanotacao),
  INDEX fk_diario_usuario_idx (usuario_idusuario ASC),
  CONSTRAINT fk_diario_usuario
    FOREIGN KEY (usuario_idusuario)
    REFERENCES usuario(idusuario))
ENGINE = InnoDB;


