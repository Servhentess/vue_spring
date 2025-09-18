-- R__classes_ajout.sql
-- Fichier repeatable réservé à l ajout de nouvelles classes (vide pour l’instant)

--INSERT INTO classes (code, libelle, description, caracs) VALUES
-- ('PALADIN','Paladin','Guerrier de lumiere','{"force":8,"dexterite":3,"intelligence":3,"vie":11}')
--ON CONFLICT (code) DO UPDATE
--  SET libelle=EXCLUDED.libelle,
--      description=EXCLUDED.description,
--      caracs=EXCLUDED.caracs;