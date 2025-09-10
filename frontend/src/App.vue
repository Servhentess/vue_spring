<template>
  <main style="max-width: 720px; margin: 2rem auto; font: 16px/1.4 system-ui">
    <h1>Vue + Spring (from-scratch)</h1>

    <section>
      <h2>Messages</h2>
      <form @submit.prevent="send">
        <input v-model="draft" placeholder="Écris un message…" />
        <button>Envoyer</button>
      </form>

      <ul>
        <li v-for="(m, i) in messages" :key="i">{{ m }}</li>
      </ul>
    </section>
  </main>
</template>

<script setup>
import { ref, onMounted } from "vue";

const messages = ref([]);
const draft = ref("");

async function load() {
  const res = await fetch("/api/messages");
  messages.value = await res.json();
}

async function send() {
  if (!draft.value.trim()) return;
  await fetch("/api/messages", {
    method: "POST",
    headers: { "Content-Type": "text/plain;charset=UTF-8" },
    body: draft.value,
  });
  draft.value = "";
  await load();
}

onMounted(load);
</script>

<style>
button {
  cursor: pointer;
}
input {
  padding: 0.4rem 0.6rem;
  margin-right: 0.5rem;
}
</style>
