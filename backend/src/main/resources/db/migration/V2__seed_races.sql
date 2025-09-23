INSERT INTO races (code, libelle, description, caracs) VALUES
 ('ELFE_NOIR','Elfe noir','Sournoi et discret',   '{"force":-2,"dexterite":0,"constitution":0,"intelligence":0, "sagesse": 0, "charisme":2}')
ON CONFLICT (code) DO NOTHING;
