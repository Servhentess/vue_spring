import type { Race } from '../types/race'
import { apiGet } from './client'

export function listRaces(): Promise<Race[]> {
  return apiGet<Race[]>('/races')
}

export function getRace(code: string): Promise<Race> {
  return apiGet<Race>(`/races/${encodeURIComponent(code)}`)
}
