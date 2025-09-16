<template>
  <section class="p-4 max-w-3xl mx-auto">
    <header class="mb-4">
      <h2 class="text-2xl font-bold">Races</h2>
      <p class="text-sm text-gray-500">Issues de la base de données</p>
    </header>

    <div v-if="loading" class="py-8">Chargement…</div>
    <div v-else-if="error" class="py-4 text-red-600">Erreur: {{ error }}</div>
    <ul v-else class="space-y-3">
      <li v-for="r in races" :key="r.code" class="border rounded p-3">
        <div class="flex items-center justify-between">
          <h3 class="text-lg font-semibold">
            {{ r.libelle }}
            <span class="text-xs text-gray-500">({{ r.code }})</span>
          </h3>
        </div>
        <p class="text-sm text-gray-700" v-if="r.description">{{ r.description }}</p>

        <details class="mt-2">
          <summary class="cursor-pointer text-sm">Caractéristiques</summary>
          <div class="grid grid-cols-2 gap-2 mt-2 text-sm">
            <div v-for="(val, key) in r.caracs" :key="key" class="flex justify-between">
              <span class="font-medium capitalize">{{ key }}</span>
              <span>{{ val }}</span>
            </div>
          </div>
        </details>
      </li>
    </ul>
  </section>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import type { Race } from '../types/race'
import { listRaces } from '../api/races'

const races = ref<Race[]>([])
const loading = ref(true)
const error = ref<string | null>(null)

onMounted(async () => {
  try {
    races.value = await listRaces()
  } catch (e: any) {
    error.value = e?.message ?? 'Erreur inconnue'
  } finally {
    loading.value = false
  }
})
</script>

<style scoped>
/* optionnel */
</style>
