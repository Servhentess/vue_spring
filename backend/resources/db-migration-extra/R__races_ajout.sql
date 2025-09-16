INSERT INTO races (code, libelle, description, caracs) VALUES
 ('ORC','Orc','Puissant mais fruste','{"force":8,"dexterite":3,"intelligence":3,"vie":11}')
ON CONFLICT (code) DO UPDATE
  SET libelle=EXCLUDED.libelle,
      description=EXCLUDED.description,
      caracs=EXCLUDED.caracs;