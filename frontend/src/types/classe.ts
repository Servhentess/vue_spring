export type Caracs = Record<string, number>

export interface Classe {
  id: number
  code: string
  libelle: string
  description: string | null
  caracs: Caracs
}
