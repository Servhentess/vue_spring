INSERT INTO races (code, libelle, description, caracs) VALUES
 ('HUMAIN','Humain','Polyvalent, adaptable',      '{"force":5,"dexterite":5,"intelligence":5,"vie":10}'),
 ('ELFE_BLEU','Elfe Bleu','Agile et affûté',      '{"force":3,"dexterite":7,"intelligence":6,"vie":9}'),
 ('ELFE_NOIR','Elfe noir','Sournoi et discret',   '{"force":3,"dexterite":7,"intelligence":8,"vie":7}'),
 ('NAIN','Nain','Solide et tenace',               '{"force":7,"dexterite":4,"intelligence":5,"vie":12}'),
 ('ORC','Orc','Puissant mais fruste',             '{"force":8,"dexterite":3,"intelligence":3,"vie":11}')
ON CONFLICT (code) DO NOTHING;
