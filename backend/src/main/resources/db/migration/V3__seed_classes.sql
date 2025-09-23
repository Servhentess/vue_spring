INSERT INTO classes (code, libelle, description, caracs) VALUES
 ('VOLEUR','Voleur','Honneur ne rime pas avec voleur',      '{"force":5,"dexterite":5,"constitution":5,"intelligence":10, "sagesse": 2, "charisme":5}'),
 ('MAGE','Mage','Seul compte les arcanes',      '{"force":5,"dexterite":5,"constitution":5,"intelligence":10, "sagesse": 2, "charisme":5}'),
 ('GUERRIER','Guerrier','Tape aussi fort que tu es con',   '{"force":5,"dexterite":5,"constitution":5,"intelligence":10, "sagesse": 2, "charisme":5}')
ON CONFLICT (code) DO NOTHING;
