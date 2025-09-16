const API_BASE = import.meta.env.VITE_API_BASE || '/api'

export async function apiGet<T>(path: string): Promise<T> {
  const res = await fetch(`${API_BASE}${path}`, {
    headers: { Accept: 'application/json' },
  })
  if (!res.ok) {
    const text = await res.text().catch(() => '')
    throw new Error(`GET ${path} -> ${res.status} ${res.statusText} ${text}`)
  }
  return res.json() as Promise<T>
}
