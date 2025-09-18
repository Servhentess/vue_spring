<template>
  <section class="p-4 max-w-3xl mx-auto">
    <header class="mb-4">
      <h2 class="text-2xl font-bold">Classes</h2>
      <p class="text-sm text-gray-500">Issues de la base de données</p>
    </header>

    <div v-if="loading" class="py-8">Chargement…</div>
    <div v-else-if="error" class="py-4 text-red-600">Erreur: {{ error }}</div>
    <ul v-else class="space-y-3">
      <li v-for="c in classes" :key="c.code" class="border rounded p-3">
        <div class="flex items-center justify-between">
          <h3 class="text-lg font-semibold">
            {{ c.libelle }}
            <span class="text-xs text-gray-500">({{ c.code }})</span>
          </h3>
        </div>
        <p class="text-sm text-gray-700" v-if="c.description">{{ c.description }}</p>

        <details class="mt-2">
          <summary class="cursor-pointer text-sm">Caractéristiques</summary>
          <div class="grid grid-cols-2 gap-2 mt-2 text-sm">
            <div v-for="(val, key) in c.caracs" :key="key" class="flex justify-between">
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
import type { Classe } from '../types/classe'
import { listClasses } from '../api/classes'

const classes = ref<Classe[]>([])
const loading = ref(true)
const error = ref<string | null>(null)

onMounted(async () => {
  try {
    classes.value = await listClasses()
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
