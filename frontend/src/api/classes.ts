import type { Classe } from '../types/classe'
import { apiGet } from './client'

export function listClasses(): Promise<Classe[]> {
  return apiGet<Classe[]>('/classes')
}

export function getClasse(code: string): Promise<Classe> {
  return apiGet<Classe>(`/classes/${encodeURIComponent(code)}`)
}
