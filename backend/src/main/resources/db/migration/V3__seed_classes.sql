INSERT INTO classes (code, libelle, description, caracs) VALUES
 ('VOLEUR','Voleur','Honneur ne rime pas avec voleur',      '{"force":0,"dexterite":5,"intelligence":2,"vie":0}'),
 ('MAGE','Mage','Seul compte les arcanes',      '{"force":0,"dexterite":2,"intelligence":5,"vie":0}'),
 ('GUERRIER','Guerrier','Tape aussi fort que tu es con',   '{"force":5,"dexterite":2,"intelligence":0,"vie":0}')
ON CONFLICT (code) DO NOTHING;
