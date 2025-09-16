export type Caracs = Record<string, number>

export interface Race {
  id: number
  code: string
  libelle: string
  description: string | null
  caracs: Caracs
}
